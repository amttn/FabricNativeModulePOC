import React, { useState } from 'react';
import { StyleSheet, View, Text, Pressable } from 'react-native';
import RTNAstroPlayerView from '../nativeModules/RTNAstroPlayerView';

export default function PlayerExample() {
  const [isPlaying, setIsPlaying] = useState(false);

  return (
    <View style={styles.container}>
      <Pressable style={styles.button} onPress={() => setIsPlaying(true)}>
        <Text>Play</Text>
      </Pressable>
      {isPlaying && (
        <RTNAstroPlayerView
          url="https://cdn.flowplayer.com/a30bd6bc-f98b-47bc-abf5-97633d4faea0/hls/de3f6ca7-2db3-4689-8160-0f574a5996ad/playlist.m3u8"
          sourceType="Hls"
          autoplay={true}
          style={styles.player}
        />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    overflow: 'hidden',
  },
  player: {
    flex: 1,
  },
  button: {
    position: 'absolute',
    width: 300,
    height: 100,
    borderWidth: 2,
    borderColor: 'green',
    alignSelf: 'center',
    justifyContent: 'center',
    alignItems: 'center',
  },
});