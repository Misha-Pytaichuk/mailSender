public class Main {
    public static void main(String[] args) {
        //String[] recipients = {"hr@cleveroad.com", "cv@apriorit.com", "jobquestions@privatbank.ua", "university.program@globallogic.com"};
        String[] recipients = {
                "ua_career@epam.com",
                "careerhub@softserveinc.com",
                "job@evoplay.com",
                "cv@ciklum.com",
                "kiev@luxoft.com",
                "hr-dp@dataart.com",
                "hr@intellias.com",
                "jobs@nixsolutions.com",
                "hr_dnepr@zone3000.net",
                "apply@infopulse.com",
                "daria.viazova@sigma.software",
                "recruitmentteam@n-ix.com",
                "eleksinfo@eleks.com",
                "ua-recr@griddynamics.com",
                "join@gr8.tech",
                "ua.recruiting@avenga.com",
                "career@temabit.com",
                "cv@evo.company",
                "jobs@astoundcommerce.com",
                "Olga.Kalion@playtika.com",
                "cv@onseo.biz",
                "ecruitment.ukraine@ubisoft.com",
                "info@intecracy.com",
                "contacts@amcbridge.com",
                "a.kravetskaya@andersenlab.com"
        };

        System.out.println(recipients.length + "\n");

        for (String recipient: recipients) {
            JavaMailUtil.sendMail(recipient);
        }
    }
}



