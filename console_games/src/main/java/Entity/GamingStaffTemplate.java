package Entity;

import enums.GamingStaffEnum;

import java.util.List;

public abstract class GamingStaffTemplate {

    GamingStaffEnum gamingStaffEnum;
    String staffName;

    public GamingStaffTemplate(GamingStaffEnum gamingStaffEnum, String staffName) {
        this.gamingStaffEnum = gamingStaffEnum;
        this.staffName = staffName;
    }

    abstract boolean coreDuty();

    abstract boolean coreDuty(List<Player> players);
}
