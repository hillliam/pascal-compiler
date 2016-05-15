package pascal;

/**
 *
 * @author liam
 */
public class varible {

    private String name;
    private boolean constant;
    private boolean localonly;
    private boolean assigned;
    private boolean used;

    public varible(String newname) {
        name = newname;
    }

    public varible(String newname, boolean local) {
        name = newname;
        localonly = local;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the constant
     */
    public boolean isConstant() {
        return constant;
    }

    /**
     * @param constant the constant to set
     */
    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    /**
     * @return the localonly
     */
    public boolean isLocalonly() {
        return localonly;
    }

    /**
     * @param localonly the localonly to set
     */
    public void setLocalonly(boolean localonly) {
        this.localonly = localonly;
    }

    /**
     * @return the assigned
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * @param assigned the assigned to set
     */
    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    /**
     * @return the used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * @param used the used to set
     */
    public void setUsed(boolean used) {
        this.used = used;
    }

}
