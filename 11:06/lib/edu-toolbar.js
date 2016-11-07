'use babel';

import EduToolbarView from './edu-toolbar-view';
import { CompositeDisposable } from 'atom';

export default {

  eduToolbarView: null,
  modalPanel: null,
  subscriptions: null,

  activate(state) {
    this.eduToolbarView = new EduToolbarView(state.eduToolbarViewState);
    this.modalPanel = atom.workspace.addModalPanel({
      item: this.eduToolbarView.getElement(),
      visible: false
    });

    // Events subscribed to in atom's system can be easily cleaned up with a CompositeDisposable
    this.subscriptions = new CompositeDisposable();

    // Register command that toggles this view
    this.subscriptions.add(atom.commands.add('atom-workspace', {
      'edu-toolbar:toggle': () => this.toggle()
    }));
  },

  deactivate() {
    this.modalPanel.destroy();
    this.subscriptions.dispose();
    this.eduToolbarView.destroy();
  },

  serialize() {
    return {
      eduToolbarViewState: this.eduToolbarView.serialize()
    };
  },

  toggle() {
    console.log('EduToolbar was toggled!');
    return (
      this.modalPanel.isVisible() ?
      this.modalPanel.hide() :
      this.modalPanel.show()
    );
  }

};
