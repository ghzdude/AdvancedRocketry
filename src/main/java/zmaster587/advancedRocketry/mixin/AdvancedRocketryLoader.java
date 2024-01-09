package zmaster587.advancedRocketry.mixin;

import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Arrays;
import java.util.List;

public class AdvancedRocketryLoader implements IEarlyMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Arrays.asList(
                "mixins.advancedRocketry.json"
        );
    }
}
