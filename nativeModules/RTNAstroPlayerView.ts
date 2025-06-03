import { requireNativeComponent } from 'react-native';
import type { RTNAstroPlayerViewProps } from '../specs/RTNAstroPlayerViewSpec';

// `requireNativeComponent` links the JavaScript component to its native counterpart.
// The string 'RTNAstroPlayerView' must match the name defined in your ViewManager.
const RTNAstroPlayerView =
  requireNativeComponent<RTNAstroPlayerViewProps>('RTNAstroPlayerView');

export default RTNAstroPlayerView;