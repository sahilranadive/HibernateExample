package com.saha.complexstructure.mapping.driver;

import com.google.cloud.sqlcommenter.threadlocalstorage.State;
import com.saha.complexstructure.mapping.model.CD;
import com.saha.complexstructure.mapping.model.Musician;
import com.saha.persistence.PersistenceManager;
import com.saha.service.CrudService;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Scope;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporters.otlp.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.OpenTelemetrySdkBuilder;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Driver {

    private static EntityManager em = PersistenceManager.getEntityManager();
    private static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

        SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
                .build();

        OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
                .setTracerProvider(sdkTracerProvider)
                .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
                .buildAndRegisterGlobal();

        Tracer tracer =
                openTelemetry.getTracer("instrumentation-library-name", "1.0.0");


        CrudService<CD> service = new CrudService<>(CD.class, em);

        Set<Musician> beatles = new HashSet<>();
        beatles.add(new Musician("John", "Lennon"));
        beatles.add(new Musician("Paul", "McCartney"));
        beatles.add(new Musician("Ringo", "Starr"));
        beatles.add(new Musician("Georges", "Harrison"));
        CD sergentPepper = new CD("Sergent Pepper");
        sergentPepper.setMusicians(beatles);

        // This mapping is most important to provide to tell hibernate
        // that this parent entity belong to the given child entity ie this cd contains the given musician
        for (Musician musician : beatles) {
            musician.setCd(sergentPepper);
        }
        State.Holder.set(
                State.newBuilder()
                        .withControllerName("sampleController")
                        .withActionName("create")
                        .withFramework("hibernate")
                        .build());

//        tx.begin();
//        service.create(sergentPepper);
//        tx.commit();

        Span span = tracer.spanBuilder("my span").startSpan();
// put the span into the current Context
        try (Scope scope = span.makeCurrent()) {
            // your use case
            tx.begin();
            for (int i = 0; i < 100000; i++)
                service.selectByIdOracle();
            tx.commit();
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }


//        tx.begin();
//        CD cd = service.findById(sergentPepper.getId());
//        System.out.println(cd.toString());
//        tx.commit();

//        tx.begin();
//        for (int i = 0; i < 100000; i++)
//            service.selectById();
//        tx.commit();

        em.close();
        PersistenceManager.close();
    }
}
