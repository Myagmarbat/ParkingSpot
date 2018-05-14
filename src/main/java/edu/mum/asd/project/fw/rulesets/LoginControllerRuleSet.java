package edu.mum.asd.project.fw.rulesets;

import edu.mum.asd.project.application.model.Staff;
import edu.mum.asd.project.application.web.BaseController;
import edu.mum.asd.project.application.web.LoginController;

/**
 * Rules: 1. All fields must be nonempty 2. ID field must be numeric 3. Zip must
 * be numeric with exactly 5 digits
 *
 */

public class LoginControllerRuleSet implements RuleSet {
	private LoginController loginController;

	@Override
	public void applyRules(BaseController ob) throws RuleException {
		loginController = (LoginController) ob;

		nonemptyRule();
//		stateRule();
//		idNumericRule();
//		zipNumericRule();
	}

	private void nonemptyRule() throws RuleException {
		Staff staff = loginController.getStaff();
		if (staff.getStaffName().trim().isEmpty() || staff.getStaffPass().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	/*private void stateRule() throws RuleException {
		String val = loginController.getState().trim();
		try {
			if (val.length() != 2)
				throw new RuleException("State must consists 2 alphabet!");
		} catch (NumberFormatException e) {
			throw new RuleException("State must consists 2 alphabet!");
		}
	}*/

	/*private void idNumericRule() throws RuleException {
		String val = loginController.getMemberId().trim();
		try {
			// if exceed Integer.MAX_VALUE it also should display right message
			Long.parseLong(val);
			// val is numeric
		} catch (NumberFormatException e) {
			throw new RuleException("ID must be numeric");
		}
	}

	private void zipNumericRule() throws RuleException {
		String val = loginController.getZip().trim();
		try {
			// if exceed Integer.MAX_VALUE it also should display right message
			Long.parseLong(val);
			// val is numeric
		} catch (NumberFormatException e) {
			throw new RuleException("Zipcode must be numeric");
		}
		if (val.length() != 5)
			throw new RuleException("Zipcode must have 5 digits");
	}*/


}
