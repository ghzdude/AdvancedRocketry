package zmaster587.advancedRocketry.mixin;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Arrays;
import java.util.List;

public class AdvancedRocketryLoader implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Arrays.asList(
                "mixins.advancedRocketry.json"
        );
    }
}
