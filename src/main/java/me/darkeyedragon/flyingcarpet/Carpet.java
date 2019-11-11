package me.darkeyedragon.flyingcarpet;

import org.bukkit.Material;

public class Carpet {

    private Material material;
    private int radius;

    public Carpet(Material material){
        this(material, 3);
    }

    public Carpet(Material material, int radius){
        this.material = material;
        this.radius = radius;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
