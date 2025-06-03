import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import RTNAstroPlayerView from '../nativeModules/RTNAstroPlayerView';

export default function PlayerExample() {
  return (
    <View style={styles.container}>
      <RTNAstroPlayerView
        url="https://cdn.bitmovin.com/content/assets/art-of-motion-dash-hls-progressive/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8"
        sourceType="Dash"
        style={styles.player}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black',
  },
  player: {
    flex: 1,
  },
});