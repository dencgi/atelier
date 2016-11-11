package dad.atelier3.mockInjectionManuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import dad.atelier3.model.Individu;
import dad.atelier3.service.ServiceIndividu;

@Configuration
@ComponentScan(basePackages = "dad.atelier3", excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = ServiceIndividu.class))
public class Config_4_MockAutowired {

	@Bean
	public ServiceIndividu serviceIndividu() {
		return new ServiceIndividu() {
			@Override
			public Individu find(String idRef) {
				System.out.println("Mock serviceIndividu !");
				return new Individu();
			}
		};
	}
}
