
package com.castores.modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class conectar {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-52-71-217-158.compute-1.amazonaws.com:5432/deqqco8s302k7o");
        dataSource.setUsername("epjvglarxrucoz");
        dataSource.setPassword("e9f4595e3d0c0f37200cf3a330a60811c510267be960ed78e42fea5fd5fae578");
        return dataSource;
    }
}
