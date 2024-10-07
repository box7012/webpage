package app.messages;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Component
public class MessageRepository {

    private DataSource dataSource;

    public MessageRepository (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    } 

    private SessionFactory sessionFactory;

    public Message saveMessage(Message message) {
        Session session = sessionFactory.openSession();
        session.persist(message);
        return message;
    }
}
