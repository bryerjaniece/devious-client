package net.runelite.api;
import java.util.EnumSet;
import lombok.AllArgsConstructor;
import java.util.Collection;

/**
 * Holds data of a RuneScape world.
 */
public interface World
{
	/**
	 * Gets all applicable world types for this world.
	 *
	 * @return the world types
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
	 * Gets the current number of players logged in the world.
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
	 * Sets the player count of the world.
	 *
	 * @param playerCount the new player count
	 */
	void setPlayerCount(int playerCount);

	/**
	 * Gets the world location value.
	 *
	 * @return the world location
	 */
	int getLocation();

	/**
	 * Sets the world location value.
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
	 * Gets the worlds index.
	 *
	 * @return the index
	 */
	int getIndex();

	/**
	 *  Sets the worlds index.
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
	 * Gets the world number.
	 *
	 * @return the world number
	 */
	int getId();

	/**
	 * Sets the world number.
	 *
	 * @param id the world number
	 */
	void setId(int id);

	/**
	 * Gets the world activity description.
	 * <p>
	 * For example, world 2 would return "Trade - Members".
	 *
	 * @return the world activity
	 */
	String getActivity();

	/**
	 * Sets the world activity description.
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
	 * Gets the address of the world.
	 *
	 * @return the world address
	 */
	String getAddress();

	/**
	 * Sets the address of the world.
	 *
	 * @param address the address
	 */
	void setAddress(String address);

	default boolean isMembers()
	{
		return getTypes().contains(WorldType.MEMBERS);
	}

	default boolean isAllPkWorld()
	{
		return WorldType.isAllPKWorld(getTypes());
	}

	default boolean isSkillTotal()
	{
		return getTypes().contains(WorldType.SKILL_TOTAL);
	}

	default boolean isTournament()
	{
		return getTypes().contains(WorldType.NOSAVE_MODE) || getTypes().contains(WorldType.TOURNAMENT_WORLD);
	}

	default boolean isLeague()
	{
		return getTypes().contains(WorldType.SEASONAL);
	}

	default boolean isNormal()
	{
		return !isAllPkWorld() && !isSkillTotal() && !isTournament() && !isLeague() && !isPvpArena() && !isQuestSpeedRunning();
	}

	default boolean isPvpArena()
	{
		return getTypes().contains(WorldType.PVP_ARENA);
	}

	default boolean isQuestSpeedRunning()
	{
		return getTypes().contains(WorldType.QUEST_SPEEDRUNNING);
	}
}
@AllArgsConstructor
public enum WorldType
{
	/**
	 * Members world type.
	 */
	MEMBERS(1),
	/**
	 * Pvp world type.
	 */
	PVP(1 << 2),
	/**
	 * Bounty world type.
	 */
	BOUNTY(1 << 5),
	/**
	 * PVP arena world type.
	 */
	PVP_ARENA(1 << 6),
	/**
	 * Skill total world type.
	 */
	SKILL_TOTAL(1 << 7),
	/**
	 * Quest speedrunning
	 */
	QUEST_SPEEDRUNNING(1 << 8),
	/**
	 * High risk world type.
	 */
	HIGH_RISK(1 << 10),
	/**
	 * Last man standing world type.
	 */
	LAST_MAN_STANDING(1 << 14),
	/**
	 * Beta world.
	 */
	BETA_WORLD(1 << 16),
	/**
	 * Beta worlds without profiles that are saved.
	 */
	NOSAVE_MODE(1 << 25),
	/**
	 * Tournament world type
	 */
	TOURNAMENT_WORLD(1 << 26),
	/**
	 * Fresh start world type
	 */
	FRESH_START_WORLD(1 << 27),
	/**
	 * Deadman world type.
	 */
	DEADMAN(1 << 29),
	/**
	 * Seasonal world type for leagues and seasonal deadman.
	 */
	SEASONAL(1 << 30);

	private final int mask;

	private static final EnumSet<WorldType> PVP_WORLD_TYPES = EnumSet.of(
		DEADMAN, // dmmt worlds are also flaged as DEADMAN
		PVP
	);

	private static final EnumSet<WorldType> DEADMAN_WORLD_TYPES = EnumSet.of(
		DEADMAN
	);

	private static final EnumSet<WorldType> HIGHRISK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK
	);

	private static final EnumSet<WorldType> ALL_HIGHRISK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN
	);

	private static final EnumSet<WorldType> ALL_PVP_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN,
		PVP
	);

	private static final EnumSet<WorldType> ALL_PK_WORLD_TYPES = EnumSet.of(
		HIGH_RISK,
		DEADMAN,
		PVP,
		BOUNTY
	);

	/**
	 * Create enum set of world types from mask.
	 *
	 * @param mask the mask
	 * @return the enum set
	 */
	public static EnumSet<WorldType> fromMask(final int mask)
	{
		final EnumSet<WorldType> types = EnumSet.noneOf(WorldType.class);

		for (WorldType type : WorldType.values())
		{
			if ((mask & type.mask) != 0)
			{
				types.add(type);
			}
		}

		return types;
	}

	/**
	 * Create mask from enum set of world types.
	 *
	 * @param types the types
	 * @return the int containing all mask
	 */
	public static int toMask(final EnumSet<WorldType> types)
	{
		int mask = 0;

		for (WorldType type : types)
		{
			mask |= type.mask;
		}

		return mask;
	}

	/**
	 * Checks whether a world having a {@link Collection} of {@link WorldType}s is a PVP world.
	 *
	 * @param worldTypes A {@link Collection} of {@link WorldType}s describing the given world.
	 * @return           True if the given worldtypes of the world are a PVP world, false otherwise.
	 * @see Client#getWorldType()
	 */
	public static boolean isPvpWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(PVP_WORLD_TYPES::contains);
	}

	public static boolean isDeadmanWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(DEADMAN_WORLD_TYPES::contains);
	}

	public static boolean isHighRiskWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(HIGHRISK_WORLD_TYPES::contains);
	}

	public static boolean isAllHighRiskWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_HIGHRISK_WORLD_TYPES::contains);
	}

	public static boolean isAllPvpWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_PVP_WORLD_TYPES::contains);
	}

	public static boolean isAllPKWorld(final Collection<WorldType> worldTypes)
	{
		return worldTypes.stream().anyMatch(ALL_PK_WORLD_TYPES::contains);
	}
}
