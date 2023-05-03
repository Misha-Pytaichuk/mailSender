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
            message.setSubject("��������/����������");
            message.setText("""
                    ³���!

                    ���� � ��������� ����� ���� �� �������� ��� ���������� �� Java Developer.

                    ���� ����� �������� �������, � ������� �������� ����� ����������� ������������� ����������� ���� �. �. �������. �������� �� ��������� ����������� ����. ����� �������� � ����.

                    � ��� ����� � ��������� ��� �� ������� ������� �� Java(��� ����������), � ����� ������ � SQL �� NoSQL ������ �����, ��� ��������� � ������������� �� ��������� ����������, ���� ������� �� �������.\s
                    ����� ��� ��������� Java-Spring, �������� ������������, �� �������� SOLID.
                    ����� ��� ����� ������ � GitHub, ��� ��������� � ��������� Git Bash.
                    ��������� �� ��� B1.

                    ���� ���� ��������� �� ������� � ����� ������, ����� ���� ���� �������� ���� � ����� ������ �� �����������, ������� ����� ��������� �� ���.
                    ���� �������� �������� ���� �� ������, ���� �� ���� ���� ����� Java ����������� � �����������.

                    ���� ��� ���������:
                    � �������(� ���� ������, ���� ����� ��� ����� ��� ����� ����, ���� �� ����� ��);
                    � �������;
                    � �� ��������� ������, ���� ���� �� ������, ��� � ��� ��������� �������� ���
                    � ������, ��� ���������� �� ����� �����
                    � ��������;
                    � ����� ��������, ���� �� ������ �� ���������

                    ����� �� �����!""");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
