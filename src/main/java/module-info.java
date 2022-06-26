module stocks.user.services {
    requires transitive stocks.commons;
    requires spring.context;
    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.tx;
    requires spring.data.jpa;
    requires spring.core;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires spring.orm;
    requires java.persistence;
    exports com.saji.users.pojo;
    exports com.saji.users to spring.beans,spring.context;
    opens com.saji.users.entities to org.hibernate.orm.core, spring.core;
    exports com.saji.users.entities to org.hibernate.orm.core;
    opens com.saji.users to spring.core, spring.context;
    opens com.saji.users.config to spring.core;
    exports com.saji.users.config to spring.beans, spring.context;
    opens com.saji.users.services to spring.core;
    exports com.saji.users.services to spring.beans, spring.context;
    opens com.saji.users.controller to spring.core;
    exports com.saji.users.controller to spring.beans, spring.context,spring.web;
}