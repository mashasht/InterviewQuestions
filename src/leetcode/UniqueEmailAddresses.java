package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String localPart = getDecipheredLocalPart(getLocalPart(emails[i]));
            String domain = getDomainPart(emails[i]);
            uniqueEmails.add(localPart + domain);
        }
        return uniqueEmails.size();
    }
    private String getLocalPart(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    private String getDomainPart(String email) {
        return email.substring(email.indexOf('@'));
    }

    private String getDecipheredLocalPart(String local) {
        if (local.contains("+")) {
            local = local.substring(0, local.indexOf("+"));
        }
        local = local.replaceAll("\\.", "");
        return local;
    }

    public static void main(String[] args) {
        UniqueEmailAddresses uea = new UniqueEmailAddresses();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uea.numUniqueEmails(emails));
    }
}