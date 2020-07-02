import { createReducer } from 'typesafe-actions';
import { JavaScriptState, JavaScriptAction } from './types';
import { UPDATE_JAVASCRIPT_CODE, UPDATE_JAVASCRIPT_RESULT } from './actions';

const initialState: JavaScriptState = {
  code: '// Code',
  result: {
    state: 'info',
    message: '코드를 실행해주세요!'
  },
};

export default createReducer<JavaScriptState, JavaScriptAction>(initialState, {
  [UPDATE_JAVASCRIPT_CODE]: (state, { payload: code }) => { return { code: code, result: state.result } },
  [UPDATE_JAVASCRIPT_RESULT]: (state, { payload: result }) => { return { code: state.code, result: result } },
});
