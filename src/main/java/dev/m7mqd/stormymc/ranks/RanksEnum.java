package dev.m7mqd.stormymc.ranks;

import lombok.Getter;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import org.bukkit.Material;

public enum RanksEnum {
    // HOPPER: EMPTY | DIAMOND | STORMY | GOLD | EMPTY
    Stormy(2, Material.OBSIDIAN),
    Diamond(1, Material.DIAMOND_BLOCK),
    Gold(3, Material.GOLD_BLOCK);

    RanksEnum(int position, Material material){
        this.position = position;
        this.material = material;
    }
    private final @Getter int position;
    private final @Getter Material material;

    public String getDisplayName(LuckPerms luckPerms){
        Group group = luckPerms.getGroupManager().getGroup(name());
        if(group == null) throw new NullPointerException("Group doesn't exist!");
        String displayName = group.getDisplayName();
        return displayName == null ? group.getName() : displayName;
    }
    public static RanksEnum getFromPosition(int position){
        for(RanksEnum ranksEnum : RanksEnum.values())
            if(ranksEnum.getPosition() == position) return ranksEnum;
        return null;
    }
}
