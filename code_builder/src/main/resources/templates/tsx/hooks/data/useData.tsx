import { useSelector } from 'react-redux';
import { RootState } from '../../models';

export const useData = () => useSelector((state: RootState) => state.data);
