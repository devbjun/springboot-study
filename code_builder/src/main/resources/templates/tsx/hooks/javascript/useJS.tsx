import { useSelector } from 'react-redux';
import { RootState } from '../../models';

export const useJS = () => useSelector((state: RootState) => state.javascript);
