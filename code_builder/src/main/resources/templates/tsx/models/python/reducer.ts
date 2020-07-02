import { createReducer } from 'typesafe-actions';
import { PythonState, PythonAction } from './types';
import { UPDATE_PYTHON_CODE, UPDATE_PYTHON_RESULT } from './actions';

const initialState: PythonState = {
  code: '# Code',
  result: {
    state: 'info',
    message: '코드를 실행해주세요!'
  },
};

export default createReducer<PythonState, PythonAction>(initialState, {
  [UPDATE_PYTHON_CODE]: (state, { payload: code }) => { return { code: code, result: state.result } },
  [UPDATE_PYTHON_RESULT]: (state, { payload: result }) => { return { code: state.code, result: result } },
});
