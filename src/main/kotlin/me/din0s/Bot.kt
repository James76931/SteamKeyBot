/*
 * MIT License
 *
 * Copyright 2019 Dinos Papakostas
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.din0s

import me.din0s.cfg.Config
import me.din0s.cfg.ConfigEntry
import me.din0s.handlers.ActivityHandler
import me.din0s.handlers.CommandHandler
import me.din0s.handlers.KeyHandler
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

val LOG: Logger = LoggerFactory.getLogger("SteamBot")

fun main() {
    KeyHandler.load()
    Config.load()

    val flags = EnumSet.allOf(CacheFlag::class.java)
    flags.remove(CacheFlag.VOICE_STATE)

    JDABuilder(ConfigEntry.TOKEN.value)
        .setAudioEnabled(false)
        .setBulkDeleteSplittingEnabled(false)
        .setDisabledCacheFlags(flags)
        .addEventListeners(ActivityHandler, CommandHandler)
        .build()
}
