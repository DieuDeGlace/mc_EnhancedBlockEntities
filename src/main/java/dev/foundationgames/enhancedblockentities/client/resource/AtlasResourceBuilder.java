package dev.foundationgames.enhancedblockentities.client.resource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import dev.foundationgames.enhancedblockentities.EnhancedBlockEntities;
import net.minecraft.client.texture.atlas.AtlasSource;
import net.minecraft.client.texture.atlas.AtlasSourceManager;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AtlasResourceBuilder {
    private static final Gson GSON = new Gson();
    private final List<AtlasSource> sources = new ArrayList<>();

    public void put(AtlasSource source) {
        sources.add(source);
    }

    public byte[] toBytes() {
        return GSON.toJson(AtlasSourceManager.LIST_CODEC.encode(this.sources, JsonOps.INSTANCE, new JsonObject())
                .getOrThrow(false, EnhancedBlockEntities.LOG::error))
                .getBytes(StandardCharsets.UTF_8);
    }
}
