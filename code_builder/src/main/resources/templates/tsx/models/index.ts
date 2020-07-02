import { combineReducers } from 'redux';
import language from './language';
import javascript from './javascript';
import python from './python';

const rootReducer = combineReducers({
  language,
  javascript,
  python
});

export default rootReducer;
export type RootState = ReturnType<typeof rootReducer>;