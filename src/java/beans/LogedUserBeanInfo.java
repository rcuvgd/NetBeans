/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;

/**
 *
 * @author tomislav
 */
public class LogedUserBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( beans.LogedUser.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
    // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_action = 0;
    private static final int PROPERTY_context = 1;
    private static final int PROPERTY_drzava = 2;
    private static final int PROPERTY_grad = 3;
    private static final int PROPERTY_ime = 4;
    private static final int PROPERTY_jmb = 5;
    private static final int PROPERTY_loged = 6;
    private static final int PROPERTY_logout = 7;
    private static final int PROPERTY_menu = 8;
    private static final int PROPERTY_message = 9;
    private static final int PROPERTY_odjavi = 10;
    private static final int PROPERTY_password = 11;
    private static final int PROPERTY_path = 12;
    private static final int PROPERTY_prezime = 13;
    private static final int PROPERTY_region = 14;
    private static final int PROPERTY_tip = 15;
    private static final int PROPERTY_ulica = 16;
    private static final int PROPERTY_ulica2 = 17;
    private static final int PROPERTY_user = 18;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[19];
    
        try {
            properties[PROPERTY_action] = new PropertyDescriptor ( "action", beans.LogedUser.class, "getAction", "setAction" ); // NOI18N
            properties[PROPERTY_context] = new PropertyDescriptor ( "context", beans.LogedUser.class, "getContext", "setContext" ); // NOI18N
            properties[PROPERTY_drzava] = new PropertyDescriptor ( "drzava", beans.LogedUser.class, "getDrzava", "setDrzava" ); // NOI18N
            properties[PROPERTY_grad] = new PropertyDescriptor ( "grad", beans.LogedUser.class, "getGrad", "setGrad" ); // NOI18N
            properties[PROPERTY_ime] = new PropertyDescriptor ( "ime", beans.LogedUser.class, "getIme", "setIme" ); // NOI18N
            properties[PROPERTY_jmb] = new PropertyDescriptor ( "jmb", beans.LogedUser.class, "getJmb", "setJmb" ); // NOI18N
            properties[PROPERTY_loged] = new PropertyDescriptor ( "loged", beans.LogedUser.class, "isLoged", "setLoged" ); // NOI18N
            properties[PROPERTY_logout] = new PropertyDescriptor ( "logout", beans.LogedUser.class, "getLogout", "setLogout" ); // NOI18N
            properties[PROPERTY_menu] = new PropertyDescriptor ( "menu", beans.LogedUser.class, "getMenu", "setMenu" ); // NOI18N
            properties[PROPERTY_message] = new PropertyDescriptor ( "message", beans.LogedUser.class, "getMessage", "setMessage" ); // NOI18N
            properties[PROPERTY_odjavi] = new PropertyDescriptor ( "odjavi", beans.LogedUser.class, "getOdjavi", "setOdjavi" ); // NOI18N
            properties[PROPERTY_password] = new PropertyDescriptor ( "password", beans.LogedUser.class, "getPassword", "setPassword" ); // NOI18N
            properties[PROPERTY_path] = new PropertyDescriptor ( "path", beans.LogedUser.class, "getPath", null ); // NOI18N
            properties[PROPERTY_prezime] = new PropertyDescriptor ( "prezime", beans.LogedUser.class, "getPrezime", "setPrezime" ); // NOI18N
            properties[PROPERTY_region] = new PropertyDescriptor ( "region", beans.LogedUser.class, "getRegion", "setRegion" ); // NOI18N
            properties[PROPERTY_tip] = new PropertyDescriptor ( "tip", beans.LogedUser.class, "getTip", "setTip" ); // NOI18N
            properties[PROPERTY_ulica] = new PropertyDescriptor ( "ulica", beans.LogedUser.class, "getUlica", "setUlica" ); // NOI18N
            properties[PROPERTY_ulica2] = new PropertyDescriptor ( "ulica2", beans.LogedUser.class, "getUlica2", "setUlica2" ); // NOI18N
            properties[PROPERTY_user] = new PropertyDescriptor ( "user", beans.LogedUser.class, "getUser", "setUser" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
    // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[0];//GEN-HEADEREND:Events
    // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_attrListener0 = 0;
    private static final int METHOD_editaction1 = 1;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[2];
    
        try {
            methods[METHOD_attrListener0] = new MethodDescriptor(beans.LogedUser.class.getMethod("attrListener", new Class[] {javax.faces.event.ActionEvent.class})); // NOI18N
            methods[METHOD_attrListener0].setDisplayName ( "" );
            methods[METHOD_editaction1] = new MethodDescriptor(beans.LogedUser.class.getMethod("editaction", new Class[] {})); // NOI18N
            methods[METHOD_editaction1].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
    // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
