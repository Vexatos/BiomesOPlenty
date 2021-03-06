package biomesoplenty.asm;

import java.io.File;
import java.util.Map;

import codechicken.core.launch.DepLoader;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions({ "biomesoplenty.asm" })
public class BOPFMLLoadingPlugin implements IFMLLoadingPlugin
{
    public BOPFMLLoadingPlugin()
    {
        DepLoader.load();
    }
    
    public static File location;
    
    @Override
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] {BOPBiomeColourBlending.class.getName()};
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
        location = (File)data.get("coremodLocation");
    }
}
