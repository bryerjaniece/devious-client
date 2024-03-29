/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

/**
 * An enumeration of prayer icons above the head.
 */
public enum HeadIcon
{
	/**
	 * Protect from melee.
	 */
	MELEE,
	/**
	 * Protect from ranged.
	 */
	RANGED,
	/**
	 * Protect from magic.
	 */
	MAGIC,
	/**
	 * Retribution prayer.
	 */
	RETRIBUTION,
	/**
	 * Smite prayer.
	 */
	SMITE,
	/**
	 * Redemption prayer.
	 */
	REDEMPTION,
	/**
	 * Protect from range and mage. (ie. used by Kalphite Queen)
	 */
	RANGE_MAGE,
	/**
	 * Protect from range and melee
	 */
	RANGE_MELEE,
	/**
	 * Protect from mage and melee
	 */
	MAGE_MELEE,
	/**
	 * Protect from range, mage, and melee
	 */
	RANGE_MAGE_MELEE,
	/**
	 * Wrath curse
	 */
	WRATH,
	/**
	 * Soult split curse
	 */
	SOUL_SPLIT,
	/**
	 * Deflect melee curse
	 */
	DEFLECT_MELEE,
	/**
	 * Deflect range curse
	 */
	DEFLECT_RANGE,
	/**
	 * Deflect magic curse
	 */
	DEFLECT_MAGE,
	/**
	 * Dampen melee curse
	 */
	DAMPEN_MELEE,
	/**
	 * Dampen range curse
	 */
	DAMPEN_RANGED,
	/**
	 * Dampen magic curse
	 */
	DAMPEN_MAGIC,
	/**
	 * Intensify (Gambit) curse
	 */
	INTENSIFY,
	/**
	 * Rebuke curse
	 */
	REBUKE,
	/**
	 * Purge curse
	 */
	PURGE,
	/**
	 * Vindication curse
	 */
	VINDICATION,
	/**
	 * Unknown curse
	 */
	UNKNOWN_1,
	UNKNOWN_2;
}
