package cz.flyultra.enums;

/**
 *
 * Type of permission
 *
 * Created by: Filip Zeman "Fly"
 *
 */
public enum TypePermission {

    OTHER(".other"),
    HAVE(".have");


    private String type;

    TypePermission(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
