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
          url="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
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