package com.ultreon.mods.motobox.automobile;

import com.ultreon.mods.motobox.render.AutomobilityModels;
import com.ultreon.mods.motobox.Automobility;
import com.ultreon.mods.motobox.util.SimpleMapContentRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;
import java.util.function.Function;

public record AutomobileFrame(
        Identifier id,
        float weight,
        FrameModel model
) implements AutomobileComponent<AutomobileFrame> {
    public static final Identifier ID = Automobility.id("frame");
    public static final SimpleMapContentRegistry<AutomobileFrame> REGISTRY = new SimpleMapContentRegistry<>();

    public static final AutomobileFrame EMPTY = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("empty"),
                    0.25f,
                    new FrameModel(
                            new Identifier("empty"),
                            Automobility.id("empty"),
                            WheelBase.basic(16, 16),
                            16, 8, 8, 4, 8, 8
                    )
            )
    );

    public static final AutomobileFrame WOODEN_MOTORCAR = REGISTRY.register(motorcar("wooden", 0.3f));
    public static final AutomobileFrame COPPER_MOTORCAR = REGISTRY.register(motorcar("copper", 0.4f));
    public static final AutomobileFrame STEEL_MOTORCAR = REGISTRY.register(motorcar("steel", 0.475f));
    public static final AutomobileFrame GOLDEN_MOTORCAR = REGISTRY.register(motorcar("golden", 0.525f));
    public static final AutomobileFrame BEJEWELED_MOTORCAR = REGISTRY.register(motorcar("bejeweled", 0.555f));

    public static final AutomobileFrame TRUCK = REGISTRY.register(truck());
    public static final AutomobileFrame MOTORBIKE = REGISTRY.register(motorbike());

    public static final AutomobileFrame STANDARD_WHITE = REGISTRY.register(standard("white"));
    public static final AutomobileFrame STANDARD_ORANGE = REGISTRY.register(standard("orange"));
    public static final AutomobileFrame STANDARD_MAGENTA = REGISTRY.register(standard("magenta"));
    public static final AutomobileFrame STANDARD_LIGHT_BLUE = REGISTRY.register(standard("light_blue"));
    public static final AutomobileFrame STANDARD_YELLOW = REGISTRY.register(standard("yellow"));
    public static final AutomobileFrame STANDARD_LIME = REGISTRY.register(standard("lime"));
    public static final AutomobileFrame STANDARD_PINK = REGISTRY.register(standard("pink"));
    public static final AutomobileFrame STANDARD_GRAY = REGISTRY.register(standard("gray"));
    public static final AutomobileFrame STANDARD_LIGHT_GRAY = REGISTRY.register(standard("light_gray"));
    public static final AutomobileFrame STANDARD_CYAN = REGISTRY.register(standard("cyan"));
    public static final AutomobileFrame STANDARD_PURPLE = REGISTRY.register(standard("purple"));
    public static final AutomobileFrame STANDARD_BLUE = REGISTRY.register(standard("blue"));
    public static final AutomobileFrame STANDARD_BROWN = REGISTRY.register(standard("brown"));
    public static final AutomobileFrame STANDARD_GREEN = REGISTRY.register(standard("green"));
    public static final AutomobileFrame STANDARD_RED = REGISTRY.register(standard("red"));
    public static final AutomobileFrame STANDARD_BLACK = REGISTRY.register(standard("black"));

    public static final AutomobileFrame RED_TRACTOR = REGISTRY.register(tractor("red"));
    public static final AutomobileFrame YELLOW_TRACTOR = REGISTRY.register(tractor("yellow"));
    public static final AutomobileFrame GREEN_TRACTOR = REGISTRY.register(tractor("green"));
    public static final AutomobileFrame BLUE_TRACTOR = REGISTRY.register(tractor("blue"));

    public static final AutomobileFrame SHOPPING_CART = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("shopping_cart"),
                    0.25f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/shopping_cart.png"),
                            Automobility.id("frame_shopping_cart"),
                            WheelBase.basic(17, 12.05f),
                            25,
                            11,
                            7,
                            17,
                            11,
                            11
                    )
            )
    );

    public static final AutomobileFrame C_ARR = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("c_arr"),
                    0.85f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/c_arr.png"),
                            Automobility.id("frame_c_arr"),
                            WheelBase.basic(44.5f, 16),
                            44f,
                            6f,
                            19.5f,
                            10.5f,
                            23,
                            23
                    )
            )
    );

    public static final AutomobileFrame PINEAPPLE = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("pineapple"),
                    0.75f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/pineapple.png"),
                            Automobility.id("frame_pineapple"),
                            WheelBase.basic(10, 18),
                            20,
                            16,
                            8,
                            6,
                            9,
                            9
                    )
            )
    );

    public static final AutomobileFrame DABABY = REGISTRY.register(
            new AutomobileFrame(
                    Automobility.id("dababy"),
                    0.93f,
                    new FrameModel(
                            Automobility.id("textures/entity/automobile/frame/dababy.png"),
                            Automobility.id("frame_dababy"),
                            WheelBase.basic(40, 8),
                            40,
                            22,
                            13,
                            3,
                            24,
                            24
                    )
            )
    );

    private static AutomobileFrame standard(String color) {
        return new AutomobileFrame(
                Automobility.id("standard_"+color),
                0.6f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/standard_"+color+".png"),
                        Automobility.id("frame_standard"),
                        WheelBase.basic(26, 10),
                        26,
                        5,
                        13,
                        3,
                        18,
                        22
                )
        );
    }

    private static AutomobileFrame motorcar(String variant, float weight) {
        return new AutomobileFrame(
                Automobility.id(variant+"_motorcar"),
                weight,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/"+variant+"_motorcar.png"),
                        Automobility.id("frame_motorcar"),
                        WheelBase.basic(32, 12),
                        28,
                        3,
                        18,
                        2,
                        23,
                        22
                )
        );
    }

    private static AutomobileFrame truck() {
        return new AutomobileFrame(
                Automobility.id("truck"),
                0.73f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/truck.png"),
                        Automobility.id("frame_truck"),
                        new WheelBase(
                                new WheelBase.WheelPos(-20, -12, 0.7f, 0, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(-20, 12, 0.7f, 180, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.RIGHT),
                                new WheelBase.WheelPos(22, -12, 0.7f, 0, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(22, 12, 0.7f, 180, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.RIGHT)
                        ),
                        28,
                        3.5f,
                        -18,
                        2,
                        34,
                        22
                )
        );
    }

    private static AutomobileFrame motorbike() {
        return new AutomobileFrame(
                Automobility.id("motorbike"),
                0.73f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/motorbike.png"),
                        Automobility.id("frame_motorbike"),
                        WheelBase.bicycleOffset(34, 0),
                        28,
                        3.5f,
                        18,
                        2,
                        22,
                        22
                )
        );
    }

    private static AutomobileFrame tractor(String color) {
        return new AutomobileFrame(
                Automobility.id(color+"_tractor"),
                0.9f,
                new FrameModel(
                        Automobility.id("textures/entity/automobile/frame/"+color+"_tractor.png"),
                        Automobility.id("frame_tractor"),
                        new WheelBase(
                                new WheelBase.WheelPos(-2, -7, 1.8f, 0, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(-2, 7, 1.8f, 180, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.RIGHT),
                                new WheelBase.WheelPos(15, -1, 1, 0, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(15, 1, 1, 180, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.RIGHT)
                        ),
                        24,
                        9,
                        9,
                        8,
                        12,
                        19
                )
        );
    }

    public static final DisplayStat<AutomobileFrame> STAT_WEIGHT = new DisplayStat<>("weight", AutomobileFrame::weight);

    @Override
    public boolean isEmpty() {
        return this == EMPTY;
    }

    @Override
    public Identifier containerId() {
        return ID;
    }

    @Override
    public void forEachStat(Consumer<DisplayStat<AutomobileFrame>> action) {
        action.accept(STAT_WEIGHT);
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public String getTranslationKey() {
        return "frame."+id.getNamespace()+"."+id.getPath();
    }

    public record FrameModel(
            Identifier texture,
            Identifier modelId,
            WheelBase wheelBase,
            float lengthPx,
            float seatHeight,
            float enginePosBack,
            float enginePosUp,
            float rearAttachmentPos,
            float frontAttachmentPos
    ) {
        @Environment(EnvType.CLIENT)
        public Function<EntityRendererFactory.Context, Model> model() {
            return AutomobilityModels.MODELS.get(modelId);
        }
    }
}
