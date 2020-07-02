import { useSelector } from 'react-redux';
import { RootState } from '../../models';

export const useLanguage = () => useSelector((state: RootState) => state.language);
