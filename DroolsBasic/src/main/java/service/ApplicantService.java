package service;

import java.io.IOException;

import org.kie.api.runtime.KieSession;

import com.ggk.drools.config.DroolsBeanFactory;

import model.Applicant;
import model.SuggestedRole;

public class ApplicantService {

	KieSession kieSession = new DroolsBeanFactory().getKieSession();

	public SuggestedRole suggestARoleForApplicant(Applicant applicant, SuggestedRole suggestedRole) throws IOException {
		kieSession.insert(applicant);
		kieSession.setGlobal("suggestedRole", suggestedRole);
		kieSession.fireAllRules();
		System.out.println(suggestedRole.getRole());
		return suggestedRole;

	}
}
