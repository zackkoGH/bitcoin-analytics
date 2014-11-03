package com.gconsulting;

import java.util.ArrayList;
import java.util.List;


/**
 * Constant values used throughout the application.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

    private Constants() {
        // hide me
    }
    //~ Static fields/initializers =============================================

	public static final String API_TYPE_PAIRS = "PAIRS";
	public static final String API_TYPE_ORDERBOOK = "ORDERBOOK";
	public static final String API_TYPE_TRADES = "TRADES";
	public static final String API_TYPE_FUNDING = "FUNDING";
	public static final String FEE_TYPE_TRADE = "TRADE";
	public static final String FEE_TYPE_DEPOSIT = "DEPOSIT";
	public static final String FEE_TYPE_WITHDRAW = "WITHDRAW";
	public static final String FEE_UNIT_EUR = "€";
	public static final String FEE_UNIT_USD = "$";
	public static final String FEE_UNIT_PERCENTAGE = "%";
	
	public static List<String> getTypes() {
		
		List<String> types = new ArrayList<String>();
		types.add(Constants.API_TYPE_PAIRS);
		types.add(Constants.API_TYPE_ORDERBOOK);
		types.add(Constants.API_TYPE_FUNDING);
		types.add(Constants.API_TYPE_TRADES);
		types.add(Constants.FEE_TYPE_TRADE);
		types.add(Constants.FEE_TYPE_DEPOSIT);
		types.add(Constants.FEE_TYPE_WITHDRAW);
		return types;		
	}

	public static List<String> getFeeUnits() {
		
		List<String> types = new ArrayList<String>();
		types.add(Constants.FEE_UNIT_EUR);
		types.add(Constants.FEE_UNIT_USD);
		types.add(Constants.FEE_UNIT_PERCENTAGE);
		return types;		
	}

	/**
     * Assets Version constant
     */
    public static final String ASSETS_VERSION = "assetsVersion";
    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /**
     * File separator from System properties
     */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * User home from System properties
     */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm";

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList";

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered";

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ROLE_ADMIN";

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "ROLE_USER";

    /**
     * The name of the user's role list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles";

    /**
     * The name of the available roles list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";

    /**
     * The name of the CSS Theme setting.
     * @deprecated No longer used to set themes.
     */
    public static final String CSS_THEME = "csstheme";
}
