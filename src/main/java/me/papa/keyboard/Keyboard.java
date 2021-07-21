package me.papa.keyboard;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

public class Keyboard implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("key", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, "test"));
        System.out.println("papa keyboard start");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (keyBinding.isPressed()) {
                client.player.sendChatMessage("zz");
            }

            while (keyBinding.wasPressed()) {
                System.out.println("player pressed Z");
                client.player.sendMessage(new LiteralText("Hello world 123"), false);
                client.player.sendChatMessage("aaaaaa");
            }
        });
    }
}
