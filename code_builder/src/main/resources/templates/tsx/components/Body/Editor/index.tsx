import React, { useEffect, useState } from 'react';

import { UnControlled as CodeMirror } from 'react-codemirror2';
import 'codemirror/mode/javascript/javascript';

import { useData } from '../../../hooks/data/useData';
import { useUpdateCode } from '../../../hooks/data/useUpdateCode';

export default () => {

  const data: { [key: string]: any } = useData();
  const updateCode = useUpdateCode();

  useEffect(() => {
    updateCode('// Code');
  }, []);

  return (
    <div className="editor" style={{ position: 'relative', top: '50px', height: '50%' }}>
      <CodeMirror 
        value={data.code}
        onChange={(editor: any, metadata: any, value: any) => updateCode(value)}
        options={{ 
          mode: 'javascript',
          theme: 'material',
          lineNumbers: true 
        }} 
      />
    </div>
  );
};