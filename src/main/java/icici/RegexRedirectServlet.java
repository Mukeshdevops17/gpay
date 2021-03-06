package icici;

/**
 * @(#)DBServlet.java 0.00 12-Feb-97 Don Corley
 *
 * Copyright (c) 2009 tourapp.com. All Rights Reserved.
 *      don@donandann.com
 */

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RedirectServlet
 * 
 * This servlet is the redirect servlet.
 */
public class RegexRedirectServlet extends RedirectServlet
{
	private static final long serialVersionUID = 1L;

	public static final String REGEX = "regex";
	public static final String REGEX_TARGET = "regexTarget";

    /**
     * returns the servlet info
     */ 
    public String getServletInfo()
    {
        return "This the redirect servlet";
    }
    /**
     * init method.
     * @exception ServletException From inherited class.
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    /**
     * Destroy this Servlet and any active applications.
     * This is only called when all users are done using this Servlet.
     */
    public void destroy()
    {
        super.destroy();
    }
    /**
     *  process an HTML get or post.
     * @exception ServletException From inherited class.
     * @exception IOException From inherited class.
     */
    public void service(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException
    {
        String strRegex = this.getInitParameter(REGEX);
        String strServer = req.getServerName();
        if (strRegex != null)
        	if (strServer != null)
        {
        	if (strServer.matches(strRegex))
            	{
            		String strTarget = this.getInitParameter(REGEX_TARGET);
            		if (strTarget != null)
            		{
            			res.sendRedirect(strTarget);
            			return;
            		}
            	}
        }
    	super.service(req, res);
    }
}
