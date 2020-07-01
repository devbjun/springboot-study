import React from 'react';

import Editor from './Editor';
import Console from './Console';

export default () => {
  return (
    <div style={{position: 'absolute', top: 0, left: 0, width: '100%', height: '100%' }}>
      <Editor />
      <Console />
    </div>
  );
};