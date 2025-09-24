package yum.procedures;

import net.minecraft.world.effect.MobEffect;

public class EffectData {
    public final MobEffect effect;
    public final int duration;
    public final int amplifier;
    
    public EffectData(MobEffect effect, int duration, int amplifier) {
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
    }
}