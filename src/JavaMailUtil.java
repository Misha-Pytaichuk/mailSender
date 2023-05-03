import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil {
    public static void sendMail(String recipient){
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccount = "pytaichuk2020ki11@student.karazin.ua";
        String password = "ygvwfhjnnrgzbczh";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });

        Message message = prepareMessage(session, myAccount, recipient);

        try {
            assert message != null;
            Transport.send(message);
            System.out.println(recipient + " -Ok");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Практика/Стажування");
            message.setText("""
                    Вітаю!

                    Пишу з проханням взяти мене на практику або стажування на Java Developer.

                    Мене звати Питайчук Михайло, я студент третього курсу Харківського національного університету імені В. Н. Каразіна. Навчаюсь на факультеті комп‘ютерних наук. Зараз проживаю в Дніпрі.

                    Я маю досвід у написання веб та декстоп додатків на Java(без фреймворків), є досвід роботи з SQL та NoSQL базами даних, вмію працювати з документацією та сторонніми бібліотеками, дуже уважний до деталей.\s
                    Зараз вчу фреймворк Java-Spring, паттерни проектування, та принципи SOLID.
                    Також маю досвід роботи з GitHub, вмію працювати з терміналом Git Bash.
                    Англійська на рівні B1.

                    Дуже хочу працювати та вчитись в вашій компанії, також дуже хочу отримати хоча б трохи досвіду від професіоналів, готовий навіть працювати за їжу.
                    Буду приділяти максимум часу та зусиль, тому що бачу себе тільки Java розробником в майбутньому.

                    Щодо рис характеру:
                    • впертий(в плані роботи, можу сидіти над зачею хоч цілий день, поки не вирішу її);
                    • уважний;
                    • не соромлюсь питати, якщо щось не розумію, але й умію вирішувати проблеми сам
                    • Дружній, без токсичності на інших людей
                    • Терпячий;
                    • Трохи скромний, поки не звикну до колективу

                    Дякую за увагу!""");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
