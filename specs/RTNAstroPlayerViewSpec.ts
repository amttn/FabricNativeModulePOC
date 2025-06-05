import type { ViewProps, HostComponent } from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

// Define the props that will be passed from React Native to the native view
export interface RTNAstroPlayerViewProps extends ViewProps {
  /**
   * The URL of the video source (e.g., MPD, HLS, Progressive).
   */
  url: string;
  /**
   * The type of the video source.
   * Supported values: 'Dash', 'Hls', 'Progressive'.
   */
  sourceType: 'Dash' | 'Hls' | 'Progressive';
  // You can add more props here, e.g.:
  autoplay?: boolean;
  // muted?: boolean;
}

// `codegenNativeComponent` generates the necessary native code for Fabric.
// The string 'RTNAstroPlayerView' must match the name used in your native ViewManager.
export default codegenNativeComponent<RTNAstroPlayerViewProps>(
  'RTNAstroPlayerView',
) as HostComponent<RTNAstroPlayerViewProps>;