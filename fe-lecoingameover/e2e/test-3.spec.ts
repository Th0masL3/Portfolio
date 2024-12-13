import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('cell', { name: '675c902fce54326ca03e82b4' }).click();
  await page.getByRole('row', { name: '675c9030ce54326ca03e82d2' }).getByRole('button').click();
  await page.getByLabel('Name:', { exact: true }).click();
});