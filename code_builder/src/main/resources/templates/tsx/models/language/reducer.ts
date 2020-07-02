import { createReducer } from 'typesafe-actions';
import { Language, LanguageState, LanguageAction } from './types';
import { SELECT_LANGUAGE } from './actions';

const initialState: LanguageState = Language.JAVASCRIPT;

export default createReducer<LanguageState, LanguageAction>(initialState, {
  [SELECT_LANGUAGE]: (state, { payload: language }) => { return language },
});
