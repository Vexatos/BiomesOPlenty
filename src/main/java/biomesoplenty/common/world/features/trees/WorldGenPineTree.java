package biomesoplenty.common.world.features.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import biomesoplenty.api.BOPBlockHelper;

public class WorldGenPineTree extends WorldGenAbstractTree
{
	public WorldGenPineTree() 
	{
		super(false);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		//TODO:		isAirBlock()
		while (world.func_147437_c(x, y, z) && y > 2)
		{
			--y;
		}

		//TODO:			  getBlock()
		Block var6 = world.func_147439_a(x, y, z);

		if (var6 != Blocks.grass && var6 != BOPBlockHelper.get("hardDirt") && var6 != Blocks.stone && var6 != Blocks.dirt)
		{
			return false;
		}
		else
		{
			for (int var7 = -2; var7 <= 2; ++var7)
			{
				for (int var8 = -2; var8 <= 2; ++var8)
				{
					//TODO:	isAirBlock()												isAirBlock()											  isAirBlock()
					if (world.func_147437_c(x + var7, y - 1, z + var8) && world.func_147437_c(x + var7, y - 2, z + var8) && !world.func_147437_c(x + var7, y, z + var8))
					{
						return false;
					}
				}
			}
			
			//settings========
			int baselength = 4 + random.nextInt(6);
			int branches = 2 + random.nextInt(4);
			//================
			
			int h = 1;
			
            var6.onPlantGrow(world, x, y - 1, z, x, y, z);
            
			for(int b = 0; b < baselength; b++)
			{
				buildBlock(world, x, y + h, z, BOPBlockHelper.get("logs4"), 0);
				h++;
			}
			
			int c = 1;
			for(int r = 0; r < branches; r++)
			{
				generateBranch(world, random, x, y + h, z, c);
				c++;
				h+=2;
			}
			
			generateTop(world, x, y + h, z);
			return true;
		}
	}

	public void generateTop(World world, int x, int y, int z)
	{
		for(int i = -1; i < 2; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				buildBlock(world, x + i, y, z + j, BOPBlockHelper.get("colorizedLeaves2"), 1);
			}
		}
		buildBlock(world, x, y, z, BOPBlockHelper.get("logs4"), 0);
		buildBlock(world, x + 1, y + 1, z, BOPBlockHelper.get("colorizedLeaves2"), 1);
		buildBlock(world, x, y + 1, z - 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
		buildBlock(world, x, y + 1, z + 1,BOPBlockHelper.get("colorizedLeaves2"), 1);
		buildBlock(world, x - 1, y + 1, z, BOPBlockHelper.get("colorizedLeaves2"), 1);
		buildBlock(world, x, y + 2, z, BOPBlockHelper.get("colorizedLeaves2"), 1);
	}
	
	public void generateBranch(World world, Random rand, int x, int y, int z, int n)
	{
		for(int i = -1; i < 2; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				buildBlock(world, x + i, y, z + j, BOPBlockHelper.get("colorizedLeaves2"), 1);
			}
		}
		
		int var99999 = rand.nextInt(2);
		int var99998 = rand.nextInt(2);
		int var99997 = rand.nextInt(2);
		int var99996 = rand.nextInt(2);
		
		if(n % 2 == 0)
		{
			//1
			if (var99998 == 0)
			{
				buildBlock(world, x + 1, y - 1, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x + 2, y - 1, z - 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99999 == 0)
				{
					buildBlock(world, x + 2, y - 2, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x + 2, y - 1, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
			else
			{
				buildBlock(world, x + 1, y, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x + 2, y, z - 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x + 2, y, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
			}
			
			//2
			if (var99997 == 0)
			{
				buildBlock(world, x - 2, y - 1, z + 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x - 1, y - 1, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99996 == 0)
				{
					buildBlock(world, x - 2, y - 2, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x - 2, y - 1, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
			else
			{
				buildBlock(world, x - 2, y, z + 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x - 1, y, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x - 2, y, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
			}
		}
		else
		{
			//1
			if (var99998 == 0)
			{
				buildBlock(world, x + 2, y - 1, z + 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x + 1, y - 1, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99999 == 0)
				{
					buildBlock(world, x + 2, y - 2, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x + 2, y - 1, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
			else
			{
				buildBlock(world, x + 2, y, z + 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x + 1, y, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99999 == 0)
				{
					buildBlock(world, x + 2, y - 1, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x + 2, y, z + 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
			
			//2
			if (var99997 == 0)
			{
				buildBlock(world, x - 1, y - 1, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x - 2, y - 1, z - 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99996 == 0)
				{
					buildBlock(world, x - 2, y - 2, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x - 2, y - 1, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
			else
			{
				buildBlock(world, x - 1, y, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				buildBlock(world, x - 2, y, z - 1, BOPBlockHelper.get("colorizedLeaves2"), 1);
				if (var99996 == 0)
				{
					buildBlock(world, x - 2, y - 1, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
				else
				{
					buildBlock(world, x - 2, y, z - 2, BOPBlockHelper.get("colorizedLeaves2"), 1);
				}
			}
		}
		
		buildBlock(world, x, y, z, BOPBlockHelper.get("logs4"), 0);
		buildBlock(world, x, y + 1, z, BOPBlockHelper.get("logs4"), 0);
	}
	
	public void buildBlock(World world, int x, int y, int z, Block block, int meta)
	{
		//TODO:	setBlock()
		world.func_147465_d(x, y, z, block, meta, 2);
	}
}