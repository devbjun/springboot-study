import { createReducer } from 'typesafe-actions';
import { DataState, DataAction } from './types';
import { UPDATE_CODE, UPDATE_RESULT } from './actions';

const initialState: DataState = {
  code: '',
  result: {
    state: 'wait',
    message: ''
  },
};

export default createReducer<DataState, DataAction>(initialState, {
  [UPDATE_CODE]: (state, { payload: code }) => { return { code: code, result: state.result } },
  [UPDATE_RESULT]: (state, { payload: result }) => { return { code: state.code, result: result } },
});
