import { useSelector } from 'react-redux';
import { RootState } from '../../models';

export const usePython = () => useSelector((state: RootState) => state.python);
