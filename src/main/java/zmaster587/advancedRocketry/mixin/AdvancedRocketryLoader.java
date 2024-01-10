package zmaster587.advancedRocketry.mixin;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import org.jetbrains.annotations.Nullable;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
@TransformerExclusions(value = {"zmaster587.advancedRocketry.mixin.ClassTransformer"})
@MCVersion("1.12.2")
public class AdvancedRocketryLoader implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public AdvancedRocketryLoader() {}

    @Override
    public List<String> getMixinConfigs() {
        return Arrays.asList(
                "mixins.advancedRocketry.json"
        );
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[] {};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
