package enums;

public enum GamingStaffEnum {
    UNKNOWN(-1,"未知"),
    DEALER(0,"发牌员");

    private Integer staffType;
    private String staffName;

    GamingStaffEnum(Integer staffType, String staffName) {
        this.staffType = staffType;
        this.staffName = staffName;
    }
}
