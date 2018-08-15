package za.co.bbd.momentum.journalrest.config;


import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BeansConfig {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerMapper() {
        List<String> mappingFiles = Arrays.asList(
                "dozer-configration-mapping.xml"
        );

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

}
