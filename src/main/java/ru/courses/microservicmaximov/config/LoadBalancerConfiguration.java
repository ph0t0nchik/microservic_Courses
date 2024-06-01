package ru.courses.microservicmaximov.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Flux;

import java.util.List;

public class LoadBalancerConfiguration {

    @Bean
    @Primary
    public ServiceInstanceListSupplier serviceInstanceListSupplier(Environment environment) {
        return new StaticServiceInstanceListSupplier(environment);
    }

    static class StaticServiceInstanceListSupplier implements ServiceInstanceListSupplier {
        private final String serviceId;

        StaticServiceInstanceListSupplier(Environment environment) {
            this.serviceId = environment.getProperty("spring.application.name");
        }

        @Override
        public String getServiceId() {
            return serviceId;
        }

        @Override
        public Flux<List<ServiceInstance>> get() {
            return Flux.just(List.of(
                    new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 1111, false),
                    new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 1112, false),
                    new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 1113, false)
            ));
        }
    }
}
