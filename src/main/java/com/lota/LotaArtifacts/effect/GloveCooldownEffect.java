package com.lota.LotaArtifacts.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.ForgeRegistries;

public class GloveCooldownEffect extends MobEffect {

    public GloveCooldownEffect(MobEffectCategory category, int color) {
        super(category, color);
        
        // Добавление модификаторов атрибутов прямо в конструкторе
        
        // -50% Урона (Multiply Total: -0.5)
        // Operation 2 = MULTIPLY_TOTAL
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "c7e3f8a0-1234-4567-89ab-cdef01234567", -0.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
        
        // Попытка найти атрибут epicfight:armor_negation динамически
        // Если null - эффект просто не будет модифицировать этот атрибут (и краша не будет).

        try {
             net.minecraft.world.entity.ai.attributes.Attribute armorNegation = ForgeRegistries.ATTRIBUTES.getValue(new net.minecraft.resources.ResourceLocation("epicfight", "armor_negation"));
             if (armorNegation != null) {
                 this.addAttributeModifier(armorNegation, "d8f4a9b1-2345-6789-01cd-ef0123456789", -100.0, AttributeModifier.Operation.ADDITION);
             }
        } catch (Exception e) {
        }
    }
}
